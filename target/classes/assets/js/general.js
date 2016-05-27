/**
 * Created by zmi on 4/24/16.
 */
// Replace the search result table on load.
if (('localStorage' in window) && window['localStorage'] !== null) {
    if ('search' in localStorage && window.location.hash) {
        $("#search").html(localStorage.getItem('search'));
    }
}

// Save the search result table when leaving the page.
$(window).unload(function () {
    if (('localStorage' in window) && window['localStorage'] !== null) {
        var form = $("#search").html();
        localStorage.setItem('search', form);
    }
});


var edit = false;

$('#edit_button').click(function() {
    if (edit == false) {
        console.log('click edit'); $(this).hide();
        $('#profile_form :input').prop('readonly', false);
        $('#submit_button').show();

        edit = true;
    }
});


$('#submit_button').click(function() {
    if (edit == true) {
        $('#profile_form').submit();
        console.log('click submit'); $(this).hide();
        $('#profile_form :input').prop('readonly', true);
        $('#edit_button').show();
        edit = false;
    }
});

function SubmitMsg() {
    console.log("form submitted!");
}
$( "form" ).submit(function() {
    console.log( $( this ).serializeArray() );
});
