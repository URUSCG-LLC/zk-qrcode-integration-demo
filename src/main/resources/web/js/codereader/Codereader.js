//called when initializing the ZK client widget
//the events will be sent to the targeted widget
function loadScanner(wgt){
	//generate a scanner object from the instascan library, and output the camera to "preview" element
	//more info here: https://github.com/schmich/instascan
	let scanner = new Instascan.Scanner({ video: document.getElementById(wgt.uuid+'-preview'), mirror: false });
    scanner.addListener('scan', function (content) {
		//fire event to the targeted ZK component, with 'content' as payload data
		wgt.fire('onScan',{scanContent:content}, null);
		console.log(content);
    });
    // grabbing the first available camera. this demo doesn't include choosing which camera to use if more than 1
    Instascan.Camera.getCameras().then(function (cameras) {
    	if (cameras.length > 0) {
        	scanner.start(cameras[0]);
		} else {
			console.error('No cameras found.');
		}
	}).catch(function (e) {
		console.error(e);
	});
}

codereader.Codereader = zk.$extends(zul.wgt.Div, {
	bind_: function () {
		this.$supers('bind_', arguments);
		loadScanner(this);
	}
});