from django.contrib import admin

# Register your models here.
from api.models import Comment, Product, ImageUrl

admin.site.register(Product)
admin.site.register(Comment)
admin.site.register(ImageUrl)