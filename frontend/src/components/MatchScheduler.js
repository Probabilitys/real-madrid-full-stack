import axios from 'axios'
import React from 'react'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import './MatchScheduler.css'
import restApi from '../api/restApi'

const MatchScheduler = () => {

    const [home, setHome] = useState('')
    const [away, setAway] = useState('')
    const [date, setDate] = useState('')

    const onSubmit = async (e) => {
        e.preventDefault()
        onAdd({ home, away, date })
        setHome('')
        setAway('')
        setDate('')
    }

    const onAdd = async (match) => {
        await restApi.post("/schedule/create-schedule", match)
        console.log('add match')
        goBack()
    }

    const navigate = useNavigate();
	const goBack = () => {
		navigate(-1);
	}

    return (
    <div>
        <button onClick={goBack} className='scheduler-btn back-btn'>Back</button>            
        <div className='scheduler-container'>
            <h1 className='scheduler-header'>Match Scheduler</h1>
            <form onSubmit={ onSubmit }>
                <div className='form-component'>
                    <input 
                        type='text'
                        required
                        value={home}
                        onChange={(e) => setHome(e.target.value)}
                    />
                    <label>Home team</label>
                </div>
                <div className='form-component'>
                    <input 
                        type='text'
                        required
                        value={away}
                        onChange={(e) => setAway(e.target.value)}
                    />
                    <label>Away team</label>
                </div>
                <div className='form-component'>
                    <input 
                        type='text'
                        required
                        value={date}
                        onChange={(e) => setDate(e.target.value)}
                    />  
                    <label>Date(yyyy-MM-dd)</label>
                </div>

                <div className='submit-btn-holder'>
                    <input className='scheduler-btn submit-btn' type='submit' value='Schedule match' />
                </div>
            </form>
        </div>
    </div>
    )
}

export default MatchScheduler