import { message } from './js_020_default.js';

document.getElementById("module01").addEventListener("click", ()=>{
    const userName = "한국인";
    const userAge = '100';
    alert(message(userName, userAge))
})