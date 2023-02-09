import React from 'react';
import './Footer.css'
import Logo from '../img/Real_Madrid_2.png'

const Footer = () => {
  return <div className='footer'>
    <img src={Logo} />
    <div>
      <a href='https://github.com/Probabilitys' target="_blank">Probabilitys</a>|
      <a href='https://github.com/Probabilitys/real-madrid' target="_blank">GitHub</a>
    </div>
    
  </div>;
};

export default Footer;
