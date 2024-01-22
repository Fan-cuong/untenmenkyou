$(document).ready(function () {
    // Ẩn các phần không cần thiết ban đầu
    $("h3, h4, h6, .pic, #retryButton, .correct, .wrong").hide();

    // Hàm thay đổi màu nền
    function changeBackgroundColor(color) {
        document.body.style.background = color;
    }

    // Hàm giảm thời gian đồng hồ
    function countdown() {
        counter -= 1;
        $("#time").text(counter);
        if (counter === 6) {
            $("#timer").css("color", "yellow");
        }
        if (counter === 0 && num <= 60) {
            $("button").hide();
            $("h3").hide();
            $("h4").hide();
            $("h5").hide();
            $("#time").hide();
            $("h1").hide();
            $("#questionMark").hide();
            $("#timeout").show();
            $("#retryButton").show();
            changeBackgroundColor("black");
        }
    }

    var correctPoints = 0;
    var counter = 60;
    var arr = [];
    var tot = "";
    var num = 1;
    var solutions = ["不正解", "正解", "不正解", "不正解", "正解", "不正解", "不正解", "不正解", "正解", "不正解"];
    var interval;

    $("#ask1").show();

    //false section start
    $("#F").click(function () {
        arr.push("不正解");
        $("#ans" + num).text("不正解");
        num += 1;
        tot = "ask" + num;
        if (num <= 10) {
            $(".question").hide();
            $("#" + tot).show();
            $("#time").text(counter);
        } else {
            $("button").hide();
            $("#time").hide();
            $("h3, h4").show();
            $("#retryButton").show();
            for (var i = 0; i < arr.length; i++) {
                if (arr[i] === solutions[i]) {
                    $("#correct" + i).show();
                    correctPoints += 1;
                } else {
                    $("#wrong" + i).show();
                }
                $("#score").text("Score: " + correctPoints + "/10");
            }
            if (correctPoints >= 8) {
                $("#good").show();
                changeBackgroundColor("linear-gradient(to top, rgba(60,70,200,0.6), rgba(0,150,0,0.5))");
            } else if (correctPoints > 4 && correctPoints < 8) {
                $("#normal").show();
                changeBackgroundColor("linear-gradient(to top, rgba(200,200,0,0.6), rgba(0,150,0,0.5))");
            } else {
                $("#loser").show();
                changeBackgroundColor("linear-gradient(to top, rgba(160,0,0,0.6), rgba(0,150,0,0.5))");
            }
        }
    });

    //true section start
    $("#V").click(function () {
        arr.push("正解");
        $("#ans" + num).text("正解");
        num += 1;
        tot = "ask" + num;
        if (num <= 10) {
            $(".question").hide();
            $("#" + tot).show();
            $("#time").text(counter);
        } else {
            $("button").hide();
            $("#time").hide();
            $("h3, h4").show();
            $("#retryButton").show();
            for (var i = 0; i < arr.length; i++) {
                if (arr[i] === solutions[i]) {
                    $("#correct" + i).show();
                    correctPoints += 1;
                } else {
                    $("#wrong" + i).show();
                }
                $("#score").text("Score " + correctPoints + " /10");
            }
            if (correctPoints >= 8) {
                $("#good").show();
                changeBackgroundColor("linear-gradient(to top, rgba(60,70,200,0.6), rgba(0,150,0,0.5))");
            } else if (correctPoints > 4 && correctPoints < 8) {
                $("#normal").show();
                changeBackgroundColor("linear-gradient(to top, rgba(200,200,0,0.6), rgba(0,150,0,0.5))");
            } else {
                $("#loser").show();
                changeBackgroundColor("linear-gradient(to top, rgba(160,0,0,0.6), rgba(0,150,0,0.5))");
            }
        }
    }); //V click

    $('#retryButton').click(function () {
        location.reload(false);
    });

    // Khởi động interval khi trang web được tải
    interval = setInterval(countdown, 1000);
});
