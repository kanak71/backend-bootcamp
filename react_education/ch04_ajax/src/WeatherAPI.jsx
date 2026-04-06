import React from 'react'
import { useEffect } from 'react';
import { useState } from 'react'

function WeatherAPI() {

    const [temp, setTemp] = useState('');
    const [desc, setDesc] = useState('');
    const [icon, setIcon] = useState('');
    const [isReady, setIsReady] = useState(false);
    const [city, setCity] = useState("Seoul");  //기본도시
    const [fetchData, setFetchData] = useState(true);

    const API_KEY = "dada6282ba6ce4d7944ca3d9f292761e";

    useEffect(() => {
        if (fetchData) {
            fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${API_KEY}&units=metric&lang=kr`)
                .then((result) => result.json())
                .then((data) => {
                    console.log("API 결과 값 ", data);
                    setTemp(data.main.temp);
                    setDesc(data.weather[0].description);
                    setIcon(data.weather[0].icon);
                    setIsReady(true);
                })
                .catch((err) => console.log(err))
        }
        setFetchData(false)
    });

    const handleClick = ()=>{
        setFetchData(true);
    }

    if(isReady){
        return (
            <div>
                <p>현재 기온 : {temp}</p>
                <p>날씨 상태 : {desc}</p>
                <p>날씨 상태 : {icon}</p>
                <img alt = 'weather State' src={`https://openweathermap.org/img/wn/${icon}@2x.png`}/>
                <button onClick={handleClick}>Fetch Weather Data</button>
            </div>
        )
    } else{
        return <div>로딩중...</div>
    }
  
}

export default WeatherAPI