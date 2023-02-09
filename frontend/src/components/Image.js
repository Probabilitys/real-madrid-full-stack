import React from 'react'

// A component containing an image

const Image = ({ source, caption }) => {

    const imageContainerStyle = {
        width: '100%',
        display: 'flex',
        flexDirection: 'column',
    }

    const textStyle = {
        textAlign: 'center'
    }

    return (
        <div style={imageContainerStyle}>
            <img src={source} />
            <h4 style={textStyle}>{caption}</h4>
        </div>
    )
}

export default Image