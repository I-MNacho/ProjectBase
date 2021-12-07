"use strict";
mapboxgl.accessToken = MapboxAPIKey;

function addMapWithLocation({container, center}) {
    const map = new mapboxgl.Map({
        container,
        style: 'mapbox://styles/mapbox/streets-v11',
        center,
        zoom: 9,
        pitch: 60
    });
    new mapboxgl.Marker()
        .setLngLat(center)
        .addTo(map);
}