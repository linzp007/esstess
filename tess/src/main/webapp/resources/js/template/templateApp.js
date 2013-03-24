
require.config({
	baseUrl :'resources/js',
	paths : {
		jquery : '../../assets/jquery/jquery-1.9.0.min',
		bootStrap : '../../assets/bootstrap/bootstrap',
		templateConfig : 'template/templateconfig',
		prettify : '../../assets/prettify/prettify',
		utils: 'utils/utils'
	}
});


require(["templateConfig"], function(templateConfig){
	templateConfig.initialize();
});