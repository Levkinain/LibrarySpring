$(document).ready(function () {
    $(".bImg").mouseenter(function(){
        $(".vImg").removeClass('vImg').addClass('bImg');
        $(this).removeClass('bImg').addClass('vImg');
    });
    $(".bImg").mouseleave(function(){
        $(".vImg").removeClass('vImg').addClass('bImg');
    });
    $("#dlt").on("click", function (e) {
        if (!confirm("Are you sure continue?")) {
            e.preventDefault();
        }
    });
});