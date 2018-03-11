from django.db import models

class Product(models.Model):
    price = models.FloatField(null=True)
    name = models.CharField(max_length=500)
    category = models.CharField(max_length=500)
    description = models.CharField(max_length=1022)
    rating = models.FloatField(null=True)
    tag = models.CharField(max_length=20, primary_key=True)

    def __str__(self):
        return self.name

class Comment(models.Model):
    #score = models.FloatField(null=True)
    description = models.CharField(max_length=500)
    title = models.CharField(max_length=200)
    user = models.CharField(max_length=100)
    product = models.ForeignKey(Product, related_name="comments", on_delete=models.CASCADE)

    def __str__(self):
        return self.title

class ImageUrl(models.Model):
    uri = models.CharField(max_length=225)
    product = models.ForeignKey(Product, related_name="images", on_delete=models.CASCADE)

    def __str__(self):
        return self.uri

class Recomendation(models.Model):
    img = models.CharField(max_length=225)
    link = models.CharField(max_length=225)
    product = models.ForeignKey(Product, related_name="recomendations", on_delete=models.CASCADE)