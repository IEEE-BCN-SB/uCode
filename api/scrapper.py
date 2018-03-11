import requests
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver.common.keys import Keys

from api.models import Product, Comment, ImageUrl, Recomendation

base_url = "http://www.adidas.es"

product_url = base_url + "/zapatilla-nmd_r1-stlt-primeknit/CQ2029.html"


def generate(url):
    tag = url[url.rfind("/")+1:-5]
    try:
        p = Product.objects.get(tag=tag)
        return p
    except Product.DoesNotExist:
        pass

    browser = webdriver.Firefox()
    browser.get(url)
    html_source = browser.page_source


    soup = BeautifulSoup(html_source, 'html.parser')

    recomended_raw = soup.find("div", "slider___23OKY").find_all("div", "item_wrapper___2-dG8")
    recomendations = []
    for recomendation in recomended_raw:
        link = "http://www.adidas.es" + recomendation.a["href"][:recomendation.a["href"].rfind("?")]
        browser.get(link)
        html_miso = browser.page_source
        miso = BeautifulSoup(html_miso, 'html.parser')
        image = miso.find("div", "glass_image_viewer___2jZMs").find("img")["src"]
        image = image[2:image.rfind(".jpg") + 4]
        recomendations.append((link, image))

    browser.quit()


    # Price
    price = float(soup.find("span", "price-big").text[2:].replace(",", "."))

    name = soup.find(attrs={"data-auto-id": "product-title"}).text
    category = soup.find(attrs={"data-auto-id": "product-category"}).text

    main = soup.find("div", "container stack ultimate-pdp-test-hide apparel-description-stack-test-hide apparel-description-stack-test-condensed-hide container___UVgdJ")
    description = main.find("div").get_text(" ")
    rating = float(soup.find("h4", "number_rating___2mC6f").text)

    raw_reviews = soup.find_all("div", "review___2fb6d")

    raw_images = soup.find("div", "glass_image_viewer___2jZMs").find_all("img")
    images = []
    for img in raw_images:
        s = img["src"]
        if s[2:5] != "www":
            continue
        images.append(s[2:s.rfind(".jpg")+4])
    images = list(set(images))



    return create_product(tag, name, category, price, description, rating, raw_reviews, images, recomendations)




def create_product(tag, name, category, price, description, rating, reviews, images, recomendations):
    prod = Product(tag=tag, name=name, category=category, price=price, description=description, rating=rating)
    prod.save()

    for img in images:
        ImageUrl(uri=img, product=prod).save()

    for link, image in recomendations:
        Recomendation(link=link, img=image, product=prod).save()

    for review in reviews:
        date = review.find("div", "review_date___2pcjN").text
        title = review.find("h6", "title___2P11X").text
        text = review.find("div", "review_text___10OPP").text
        user = review.find("div", "nickname___3YuUD").strong.text
        Comment(description=text, title=title, user=user, product=prod).save()

    return prod