"use strict";
mapboxgl.accessToken = MapboxAPIKey;

function addMapWithLocation({container, center, popup}) {
    const map = new mapboxgl.Map({
        container,
        style: 'mapbox://styles/mapbox/streets-v11',
        center,
        zoom: 9,
        pitch: 60
    });
    const marker = new mapboxgl.Marker().setLngLat(center);
    if(popup) {
        const {title, description, offset=10} = popup;
        let htmlText = `<h3>${title}</h3>`;
        if(description) {
            htmlText += `<p>${description}</p>`;
        }
        marker.setPopup(new mapboxgl.Popup({ offset }).setHTML(htmlText));
    }
    marker.addTo(map);
}