import React from 'react'

function Wrapper({children}) {

    const boardWrapper = {
        border : '1px solid blue',
        padding : '20px'
    }

  return (
    <div style={boardWrapper}>
        {children}
    </div>
  )
}

export default Wrapper