//삭제버튼 노출/비노출처리
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

//수정버튼 노출/비노출처리
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


//모달 띄울때 필요한 일정값 가져오는 함수
/*function dateParameter(){
    var parameter= [];
    parameter[0]= document.getElementById()
    parameter[1]=startTime;
    parameter[2]=endTime;
    return parameter;
}*/
//각 일정의 수정버튼 클릭 시 수정 모달 노출
function editTarget(scheduleNo){
    var scheduleDate = document.getElementById('scheduleDate'+scheduleNo).value;
    var scheduleStartTime = document.getElementById('scheduleStartTime'+scheduleNo).value;
    var scheduleEndTime = document.getElementById('scheduleEndTime'+scheduleNo).value;
    var text = document.getElementById('text'+scheduleNo).value;

    openModal('editModal', scheduleNo, scheduleDate, scheduleStartTime, scheduleEndTime, text);
}

function openModal(editModal, scheduleNo, scheduleDate, scheduleStartTime, scheduleEndTime, text){
    var zIndex = 9999;
    var modal = document.getElementById(editModal);

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

    // 모달창에 값을 표시하는 로직 추가
    var modalContent = modal.querySelector('.modalContent');

    modalContent.innerHTML = `
        <input type="hidden" name="scheduleNo" value="${scheduleNo}">
        <div>
        ${scheduleDate}일
        </div>
        <div>
            시작 : <input type="time" name="scheduleStartTime" value="${scheduleStartTime}" min="00:00" max="23:59">
            종료 : <input type="time" name="scheduleEndTime" value="${scheduleEndTime}" min="00:00" max="23:59">
        </div>
        <div>
            <input type="text" name="text" value="${text}">
        </div>
    `;

}