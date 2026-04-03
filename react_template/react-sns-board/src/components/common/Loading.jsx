import './Loading.css'

function Loading({ size = 'medium', fullScreen = false }) {
  if (fullScreen) {
    return (
      <div className="loading-fullscreen">
        <div className={`spinner spinner-${size}`}></div>
        <p>로딩 중...</p>
      </div>
    )
  }

  return (
    <div className="loading-container">
      <div className={`spinner spinner-${size}`}></div>
    </div>
  )
}

export default Loading
