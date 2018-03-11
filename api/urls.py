from django.conf.urls import url
from rest_framework.urlpatterns import format_suffix_patterns
from api import views


urlpatterns = [
    url(r'^test$', views.Test.as_view()),
    url(r'^product$', views.fake_data),
    url(r'^products$', views.ProductItem.as_view()),
]