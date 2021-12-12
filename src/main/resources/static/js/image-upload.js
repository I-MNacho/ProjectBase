"use strict";
const client = filestack.init(FileStackAPIKey);
function onUploadDone(result) {
    console.log(result)
    const url = result.filesUploaded[0].url
    $('#spot-photo').attr({src: url})
    $('#spot-photo-input').val(url)
}
const picker = client.picker({onUploadDone});

function openFilePicker() {
    picker.open();
}