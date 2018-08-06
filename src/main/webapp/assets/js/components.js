$(document).ready(function() {
	M.updateTextFields();
	$('.tabs').tabs();
	$('.tooltipped').tooltip();
	$('#task-details').characterCounter();
	$('.sidenav').sidenav();
	
	//fechar alerts
	$('#alert_close').click(function(){
		$( "#alert_box" ).fadeOut( "slow", function() {
		});
	});
});