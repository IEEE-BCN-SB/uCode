from django.http import JsonResponse
from django.shortcuts import render
from django.contrib.auth.models import User

# Create your views here.
from rest_framework import generics
from rest_framework.decorators import api_view
from rest_framework.response import Response

from api import scrapper
from api.serializers import UserSerializer, ProductSerializer


class Test(generics.ListAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer

class ProductItem(generics.RetrieveAPIView):
    serializer_class = ProductSerializer

    def get_object(self):
        url = self.request.query_params["uri"]
        return scrapper.generate(url)

@api_view(['GET'])
def fake_data(request):
    """
    List all code snippets, or create a new snippet.
    """
    return JsonResponse({
    "price": 179.95,
    "name": "Zapatilla NMD_R1 STLT Primeknit",
    "category": "Mujer Originals",
    "description": "Zapatilla NMD_R1 STLT Primeknit Innovación en continua evolución El diseño futurista y audaz de la NMD la ha convertido en una abanderada del estilo urbano actual. Esta zapatilla para mujer desafía lo establecido inspirándose en el pasado de adidas y adaptándolo al presente. Presenta una parte superior de tejido adidas Primeknit que se adapta al pie como un guante y te ofrece un ajuste cómodo y seguro. Incorpora la tecnología Boost que te proporciona un retorno de energía sin fin a cada paso. Las inserciones de EVA en la mediasuela le confieren el auténtico estilo de la NMD. La tecnología Boost es nuestro mejor sistema de amortiguación adidas Primeknit te ofrece una sujeción adaptable y un confort ultraligero Parte superior de una sola pieza con estampado técnico Inserciones de EVA moldeada en la mediasuela con el característico sello de NMD Refuerzo del talón moldeado Número de artículo: CQ2029 Color del artículo: Raw Steel/Ash Pearl/Ftwr White",
    "comments": [
        {
            "description": "me gusta mas que nada por su comodidad al caminar, el modelo es muy delicado sencillo para mi es perfecto se los recomiendo.",
            "title": "es muy comodo, perfecto y el modelo exelente",
            "user": "MARREROS21"
        },
        {
            "description": "Me gusta el producto porque me gusta su diseño y me resultan cómodas estas mallas.",
            "title": "Me gusta comprar en Adidas.",
            "user": "ukra"
        },
        {
            "description": "Por qué su diseño es clásico pero a la vez moderno, su tela muy cómoda y al Usarlo y hacer ejercicio me mantiene fresca",
            "title": "Mi mejor adquisición hasta ahora",
            "user": "Olytorres07"
        },
        {
            "description": "Son elegantes y lucen mucho, súper favorecedores ajustan perfecto",
            "title": "Súper cómodos",
            "user": "LidiaTh"
        },
        {
            "description": "Son como se observa en la foto, sientan muy bien y son muy cómodas para realizar deporte",
            "title": "Me encanta",
            "user": "Carmen99277"
        }
    ],
    "images": [
        "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw213185ff/zoom/CQ2029_06_standard.jpg",
        "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dwf391ddc9/zoom/CQ2029_05_standard.jpg",
        "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dwfac4dff1/zoom/CQ2029_04_standard.jpg",
        "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dwecab9528/zoom/CQ2029_02_standard.jpg",
        "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw75d67fc0/zoom/CQ2029_01_standard.jpg",
        "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw605b3b52/zoom/CQ2029_02_hover_frv.jpg",
        "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw3374f1ed/zoom/CQ2029_43_detail.jpg",
        "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw01a7b58e/zoom/CQ2029_03_standard.jpg",
        "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw18c12e36/zoom/CQ2029_42_detail.jpg",
        "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dwf5149e84/zoom/CQ2029_07_standard.jpg",
        "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw6e081989/zoom/CQ2029_41_detail.jpg"
    ],
    "recomendations": [
        {
            "link": "http://www.adidas.es/zapatilla-nmd_r1-stlt-primeknit/CQ2028.html",
            "img": "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw737621ff/zoom/CQ2028_01_standard.jpg"
        },
        {
            "link": "http://www.adidas.es/zapatilla-nmd_r1-stlt-primeknit/CQ2030.html",
            "img": "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw00b5e7f5/zoom/CQ2030_01_standard.jpg"
        },
        {
            "link": "http://www.adidas.es/zapatilla-nmd_r1-stlt-primeknit/AC8326.html",
            "img": "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw7679b2ae/zoom/AC8326_01_standard.jpg"
        },
        {
            "link": "http://www.adidas.es/zapatilla-nmd_r1-primeknit/CQ2041.html",
            "img": "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw6f3a4cd0/zoom/CQ2041_01_standard.jpg"
        },
        {
            "link": "http://www.adidas.es/zapatilla-nmd_racer-primeknit/CQ2032.html",
            "img": "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw6ed5cda8/zoom/CQ2032_01_standard.jpg"
        },
        {
            "link": "http://www.adidas.es/zapatilla-ultraboost-x/BB6155.html",
            "img": "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw1a684010/zoom/BB6155_01_standard.jpg"
        },
        {
            "link": "http://www.adidas.es/zapatilla-nmd_racer-primeknit/CQ2442.html",
            "img": "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dwbf0a302a/zoom/CQ2442_01_standard.jpg"
        },
        {
            "link": "http://www.adidas.es/zapatilla-nmd_r1-primeknit/CQ2040.html",
            "img": "www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw29adec95/zoom/CQ2040_01_standard.jpg"
        }
    ]
})