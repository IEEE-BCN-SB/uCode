from django.conf.urls import url, include
from django.contrib import admin

# Wire up our API using automahtic URL routing.
# Additionally, we include login URLs for the browsable API.


urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url(r'^', include('api.urls')),
]
