//function submitForm() {
//    console.log('Submit button clicked');
//
//    var form = document.getElementById("homenForm");
//    var formData = new FormData(form);
//
//    // Gửi dữ liệu form bằng phương thức POST
//    fetch(form.action, {
//        method: 'POST',
//        body: formData,
//    })
//    .then(response => response.json())
//    .then(resultData => {
//        // Hiển thị kết quả trên trang result.html
//        displayResult(resultData);
//    })
//    .catch(error => {
//        console.error('Error:', error);
//    });
//}
//
//function displayResult(resultData) {
//    console.log('Displaying result:', resultData);
//
//    // Hiển thị trang result.html
//    window.location.href = "/result";
//}
