"use strict";
mapboxgl.accessToken = MapboxAPIKey;

// function initMap({container, center=[-98.491142, 29.424349], zoom=9, pitch=60, markers}) {
//     const map = {}
//     const mapbox = new mapboxgl.Map({
//         container,
//         style: 'mapbox://styles/mapbox/streets-v11',
//         center,
//         zoom,
//         pitch
//     });
//     mapbox.on('load', () => {
//         mapbox.loadImage('/images/gray-pin-icon.png', (error, image) => {
//             if (error) throw error;
//             mapbox.addImage('unselected-icon', image);
//             addSpotMarkers(spots.map(createMapMarkers));
//             map.loadImage('/images/blue-pin-icon.png', (error, image) => {
//                 if (error) throw error;
//                 map.addImage('selected-icon', image);
//                 if(event.spot) {
//                     selectSpot({features: [createMapMarkers(event.spot)]})
//                 }
//             })
//         })
//     })
//
//
//
//     function selectSpot(e) {
//         const {
//             id,
//             geometry: { coordinates }
//         } = e.features[0];
//         // Set form value for spot and remove invalid attributes
//         $("#spot").val(id);
//         $("#spot-search").attr({ placeholder: "Search by title, description, tags"})
//         $(".search").removeClass("invalid")
//         // Center this spot
//         map.flyTo({ center: coordinates });
//         // Change image to blue to show that this spot is selected
//         map.setLayoutProperty('spots', 'icon-image',
//             [
//                 'match',
//                 ['id'],
//                 id, 'selected-icon', 'unselected-icon'
//             ]
//         )
//         try {
//             map.removeLayer("circle");
//             map.removeSource("circle");
//         } catch(e) {}
//         map.addSource("circle", {
//             "type": "geojson",
//             "data": {
//                 "type": "FeatureCollection",
//                 "features": [e.features[0]]
//             }
//         })
//         map.addLayer({
//             id: 'circle',
//             type: 'circle',
//             source: 'circle',
//             paint: {
//                 'circle-radius': 50,
//                 'circle-color': '#007BFF',
//                 'circle-stroke-color': '#007BFF',
//                 'circle-stroke-width': 2,
//                 'circle-opacity': 0.085
//             }
//         });
//         return e.features[0];
//     }
//     return {
//         mapbox,
//     }
// }
//
//     function setMarkers(markers) {
//         map.markers = markers.map(({id, latitude, longitude, ...properties}) => ({
//             id,
//             type: "Feature",
//             properties,
//             geometry: {
//                 type: "Point",
//                 coordinates: [longitude, latitude]
//             }
//         }))
//         mapbox.addSource("spots", {
//             "type": "geojson",
//             "data": {
//                 "type": "FeatureCollection",
//                 "features": map.markers
//             }
//         })
//         mapbox.addLayer({
//             'id': 'spots',
//             'type': 'symbol',
//             'source': 'spots',
//             'layout': {
//                 'text-field': ['get', 'title'],
//                 'text-variable-anchor': ['top', 'bottom', 'left', 'right'],
//                 'text-radial-offset': 1,
//                 'text-justify': 'auto',
//                 'icon-image': 'unselected-icon', // reference the image
//                 'icon-size': 0.15,
//                 'icon-allow-overlap': true
//             }
//         });
//         mapbox.on('click', 'spots', selectSpot)
//     }

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