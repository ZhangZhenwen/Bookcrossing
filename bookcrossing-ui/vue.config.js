/**
 * @author zhenwen
 * @date 2021/9/9
 */

module.exports = {

    lintOnSave: false,

    devServer: {
        port: 8000,

        proxy: {
            '^/api': {
                target: 'http://localhost:8080/',
                changeOrigin: true,
                pathRewrite: {
                    "^/api": ""
                }
            }
        },

        overlay: {
            warnings: true,
            errors: true
        }
    }
}