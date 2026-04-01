
function magicPrint(){
    var OddMagicSquare = new OddMagic();
    OddMagicSquare.makeMagic(3);
    var magic = OddMagicSquare.getMagic();

    //화면에 table로 출력을 해본다
    //<table><tr><td></td></tr></table>
    var printMagic = "<table border='1'>";
    for(let i=0; i<magic.length; i++){
        printMagic += "<tr>";
        //값을 만들어 주는 td
        for(let j=0; j<magic.length; j++){
            printMagic += "<td>"+magic[i][j]+"</td>";
        }

        printMagic += "</tr>";
    }
    printMagic += "</table>";

    document.getElementById("magicPrintArea").innerHTML = printMagic;
}




var OddMagic = function(){
    // 클래스 내부에 있는 것을 외부로 노출 this 사용

    var magic;

    //1) 공간을 생성(외부x)
    //Array 만들게 되면 동적변수 : undifinded로 입력된다
    makeArray = function(n){
        magic = Array(n);
        for(let i=0; i<magic.length; i++){
            magic[i] = new Array(magic.length);
        }   
    }//makeArray

    //2) 공간연산(외부o)
    this.makeMagic = function(n){
        makeArray(n);

        var len = magic.length;
        var x = 0;
        var y = parseInt(len/2);

        magic[x][y] = 1;

        //입력되는값
        for(let i=2; i<=len*len; i++){
            let tmpx = x;
            let tmpy = y;

            if(x-1<0){
                x = len-1;
            }else {
                x--;
            }

            if(y-1<0){
                y = len-1;
            } else{
                y--;
            }

            //변경된 x와 y의 array에 값이 있다면
            //undifinded가 아니라면 
            if(magic[x][y] != undefined){
                x = tmpx +1;
                y = tmpy;
            }

            magic[x][y] = i;
        }
    }//makeMagic

    //3) getter를 통해서 결과를 외부에 리턴
    this.getMagic = function() {
        return magic;
    }
}