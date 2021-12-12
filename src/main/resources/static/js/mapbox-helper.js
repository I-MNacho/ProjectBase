"use strict";
mapboxgl.accessToken = MapboxAPIKey;

function addMap({container, center=[-98.491142, 29.424349], zoom=9, pitch=60}) {
    const map = new mapboxgl.Map({
        container,
        style: 'mapbox://styles/mapbox/streets-v11',
        center,
        zoom,
        pitch
    });
    map.addMarker = ({ center, popup }) => {
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
        return marker;
    }
    return map;
}

function addMapWithLocation({container, center=[-98.491142, 29.424349], popup, zoom=9, pitch=60}) {
    const map = addMap({container, center, zoom, pitch});
    map.addMarker({center, popup})
    return map;
}