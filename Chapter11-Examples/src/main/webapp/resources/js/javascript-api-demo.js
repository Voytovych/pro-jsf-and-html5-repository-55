function refreshClicks(source, event) {
    jsf.ajax.request(source, event, {render: 'clicks'});
}

function saveName(source, event) {
    jsf.ajax.request(source, event, {render: 'my-name-form:my-name-display', execute: '@form'});
}