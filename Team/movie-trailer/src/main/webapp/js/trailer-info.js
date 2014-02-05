function change(id){
	    
	    homeProxy.ajaxTest(id,function(result){
	    	System.out.println("asdghsaghjf"+result);
	    	var src=document.getElementsByTagName("iframe");
			src[0].setAttribute( "result");
			document.getElementById("iframe").load();
			document.getElementById("iframe").play();
	    	
	    });
		
		
}