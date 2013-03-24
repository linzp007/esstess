
require.config({
	baseUrl :'resources/js-build',
	paths : {
		jquery : '../../assets/jquery/jquery-1.9.0.min',
		bootStrap : '../../assets/bootstrap/bootstrap.min',
		templateConfig : 'template/templateconfig',
		prettify : '../../assets/prettify/prettify',
		utils: 'utils/utils'
	}
});


require(["templateConfig"], function(templateConfig){
	templateConfig.initialize();
});