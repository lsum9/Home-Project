
/*document.getElementById('showDelBtn').addEventListener('click', function() {
   s
});

document.getElementById('showEditBtn').addEventListener('click', function() {
    // 모달창 띄우기
    modal('my_modal');
});*/

/*function showDelBtn(flag){
    var delBtn = document.getElementsByClassName("delBtn");
    alert(flag);
    if(flag == false){
        for(var i = 0; i < delBtn.length ; i++){
            delBtn[i].style.display="block";
        }
        flag = true;
    }
}*/

function showDelBtn(){
    var delBtn = document.getElementsByClassName('delBtn');
    var delFlag = document.getElementById('delFlag').value;
    if(delFlag == "false"){
        for(var i = 0; i < delBtn.length ; i++){
            delBtn[i].style.display="block";
        }
        document.getElementById('delFlag').value = "true";
    }else{
        for(var i = 0; i < delBtn.length ; i++){
            delBtn[i].style.display="none";
        }
        document.getElementById('delFlag').value = "false";
    }
}

function showEditBtn(){
    var editBtn = document.getElementsByClassName('editBtn');
    var editFlag = document.getElementById('editFlag').value;
    if(editFlag == "false"){
        for(var i = 0; i < editBtn.length ; i++){
            editBtn[i].style.display="block";
        }
        document.getElementById('editFlag').value = "true";
    }else{
        for(var i = 0; i < editBtn.length ; i++){
            editBtn[i].style.display="none";
        }
        document.getElementById('editFlag').value = "false";
    }
}

function modal(id) {
    var zIndex = 9999;
    var modal = document.getElementById(id);

    // 모달 div 뒤에 희끄무레한 레이어
    var bg = document.createElement('div');
    bg.setStyle({
        position: 'fixed',
        zIndex: zIndex,
        left: '0px',
        top: '0px',
        width: '100%',
        height: '100%',
        overflow: 'auto',
        // 레이어 색갈은 여기서 바꾸면 됨
        backgroundColor: 'rgba(0,0,0,0.4)'
    });
    document.body.append(bg);

    // 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
    modal.querySelector('.modal_close_btn').addEventListener('click', function() {
        bg.remove();
        modal.style.display = 'none';
    });

    modal.setStyle({
        position: 'fixed',
        display: 'block',
        boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',

        // 시꺼먼 레이어 보다 한칸 위에 보이기
        zIndex: zIndex + 1,

        // div center 정렬
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        msTransform: 'translate(-50%, -50%)',
        webkitTransform: 'translate(-50%, -50%)'
    });
}

// Element 에 style 한번에 오브젝트로 설정하는 함수 추가
Element.prototype.setStyle = function(styles) {
    for (var k in styles) this.style[k] = styles[k];
    return this;
};

document.getElementById('popup_open_btn').addEventListener('click', function() {
    // 일정추가 모달창 띄우기
    modal('my_modal');
});

function editParameter(scheduleNo){
    return scheduleNo;
}
document.getElementById('editBtn'+ editParameter()).addEventListener('click', function() {
    // 모달창 띄우기
    modal('editModal');
});