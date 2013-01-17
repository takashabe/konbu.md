$(function () {
    var sample = [
        "# write markdown text within this textarea." ,
        "" ,
        "----" ,
        "## Github" ,
        "" ,
        "<https://github.com/takashabe/>" ,
        "" ,
        "----" ,
        "" ,
        "## thanks" ,
        "" ,
        "* [knockoff](https://github.com/tristanjuricek/knockoff)"
    ].join("\n");

    var activeTab = $('ul.nav li.active a').attr("href");
    $('a[data-toggle="tab"]').on('shown', function (e) {
        activeTab = $(e.target).attr("href");
        konbu();
    });

    function konbu() {
        var data = {request: $('#input').val()};
        $.ajax({
            type: "POST",
            url: "konbu",
            data: data
        }).done(function (data) {
                if (activeTab == "#preview") {
                    $('#preview').html(data);
                } else if (activeTab === "#html") {
                    escapeHtml(data);
                }
            }).fail(function (data) {
                alert("Fail !!!");
            });
    };

    function escapeHtml(string) {
        var pre = $('<pre>').text(string);
        $('#html').html(pre);
    };

    $('#input').val(sample);
    konbu();
    $('#input').bind('keyup', function () {
        konbu();
    });
});