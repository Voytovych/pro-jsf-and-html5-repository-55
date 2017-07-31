function outputAjaxEvent(data) {
    console.log(data);
}

function outputError(errorData) {
    console.log(errorData.type + " (" + errorData.status + "): " + errorName + ". " + errorDescription);
    // Register error on a remote error logging server
}

function showProgress(data) {
    if (data.status === 'begin') {
        toggle_visibility('in-progress');
    } else if (data.status === 'success') {
        toggle_visibility('in-progress');
    }
}

jsf.ajax.addOnEvent(outputAjaxEvent);
jsf.ajax.addOnEvent(showProgress);
jsf.ajax.addOnError(outputError);