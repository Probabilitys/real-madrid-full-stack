import React from 'react'
import { HashRouter as Router, Routes, Route } from 'react-router-dom'
import NavBar from '../components/NavBar'
import Home from '../pages/Home'
import Players from '../pages/Players'
import Header from '../components/Header'
import About from '../pages/About'
import Footer from '../components/Footer'
import Honours from './Honours'
import './Application.css'
import MatchScheduler from '../components/MatchScheduler'
import MatchesDisplay from '../components/MatchesDisplay'
import UpdateSchedule from '../components/UpdateSchedule'

const Application = () => {

    return (
        <Router basename='/'>
            <Header />
            <NavBar />
            <div className='container'>
                <Routes>
                    <Route path="" exact element={<Home />} />
                    <Route path="honours" exact element={<Honours />} />
                    <Route path="matches" exact>
                        <Route path="" element={<MatchesDisplay />} />
                        <Route path="schedule" element={<MatchScheduler />}/>
                        <Route path="update-schedule/:id" element={<UpdateSchedule />}/>
                    </Route>
                    <Route path="about" exact element={<About />} />
                    <Route path="players" exact element={<Players />} />
                </Routes>       
            </div>
            <Footer />
        </Router>
    )
}

export default Application