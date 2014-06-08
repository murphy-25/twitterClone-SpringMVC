$(document).ready(function() {
    $('#button').popover({
        placement : 'bottom',
        html: 'true',
        content : function() {
            return $('.popover-content').html();
        }
    });
});