// 读取token
let tokenName="malltoken";
export function getToken(){
    return window.sessionStorage.getItem(tokenName);
}
export function setToken(token){
    window.sessionStorage.setItem(tokenName,token);
}
