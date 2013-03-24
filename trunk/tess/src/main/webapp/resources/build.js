//node r.js -o build.js
({
	baseUrl:'./js',
	paths: {
		jquery : '../../assets/jquery/jquery-1.9.0.min',
		bootStrap : '../../assets/bootstrap/bootstrap.min',
		templateConfig : 'template/templateconfig',
		prettify : '../../assets/prettify/prettify',
		utils: 'utils/utils'
    },
    dir:'js-build',
    modules :[{
    	name:'template/templateApp'
    }]
})