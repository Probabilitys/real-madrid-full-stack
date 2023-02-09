import axios from 'axios'
import React, { useEffect } from 'react'
import { useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import './UpdateSchedule.css'
import restApi from '../api/restApi'

const UpdateSchedule = () => {

    const [home, setHome] = useState('')
    const [away, setAway] = useState('')
    const [date, setDate] = useState('')

    const {id} = useParams()

    useEffect(() => {
        loadSchedule()
    }, [])

    const loadSchedule = async () => {
        const response = await restApi(`/schedule/get-schedule/${id}`)
        const schedule = response.data
        setHome(schedule.home)
        setAway(schedule.away)
        setDate(schedule.date)
    }

    const onSubmit = async (e) => {
        const schedule = {home, away, date}
        e.preventDefault()
        await restApi.put(`/schedule/update-schedule/${id}`, schedule)
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
            <h1 className='scheduler-header'>Update Match</h1>
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
                    <input className='scheduler-btn submit-btn' type='submit' value='Update Match' />
                </div>
            </form>
        </div>
    </div>
    )
}

export default UpdateSchedule