from django.contrib.auth.models import User
from rest_framework import serializers

from api.models import Product, Comment, ImageUrl, Recomendation


class UserSerializer(serializers.ModelSerializer):

    class Meta:
        model = User
        fields = '__all__'

class ImageUrlSerializer(serializers.ModelSerializer):
    class Meta:
        model = ImageUrl
        fields = ["uri"]


class CommentSerializer(serializers.ModelSerializer):
    class Meta:
        model = Comment
        fields = ["description", "title", "user"]

class RecomendationSerializer(serializers.ModelSerializer):
    class Meta:
        model = Recomendation
        fields = ["link", "img"]

class TrackListingField(serializers.RelatedField):
    def to_representation(self, value):
        return str(value)



class ProductSerializer(serializers.ModelSerializer):
    comments = CommentSerializer(many=True, read_only=True)
    images = TrackListingField(many=True, read_only=True)
    recomendations = RecomendationSerializer(many=True, read_only=True)

    class Meta:
        model = Product
        fields = ["price", "name", "category", "description", "comments", "images", "recomendations"]

class Dummy(serializers.Serializer):
    def to_representation(self, instance):
        return ''''''
