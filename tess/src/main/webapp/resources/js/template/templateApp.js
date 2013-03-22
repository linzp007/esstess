
require.config({
	baseUrl :'resources/js',
	paths : {
		jquery : '../../assets/jquery/jquery-1.9.0.min',
		bootStrap : '../../assets/bootstrap/bootstrap',
		templateConfig: 'template/templateconfig'
	}
});


require(["templateConfig"], function(templateConfig){
	templateConfig.initialize("helloworld");
});