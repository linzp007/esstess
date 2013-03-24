//Ñ¹Ëõ·½·¨maven requirejs:optimize
({
	baseUrl:'${project.webapp}/resources/js',
	paths: {
		jquery : '${project.webapp}/assets/jquery/jquery-1.9.0.min',
		bootStrap : '${project.webapp}/assets/bootstrap/bootstrap.min',
		templateConfig : 'template/templateconfig',
		prettify : '${project.webapp}/assets/prettify/prettify',
		utils: 'utils/utils'
    },
    dir:'${project.webapp}/resources/js-build',
    modules :[{
    	name:'template/templateApp'
    }]
})
