import React from 'react'
import { useState, useEffect } from 'react'
import { Link, useParams } from 'react-router-dom'
import restApi from '../api/restApi'
import Match from './Match'
import './MatchesDisplay.css'

const MatchesDisplay = () => {

    const [matches, setMatches] = useState([])

    const {id} = useParams()

    useEffect(() => {
        loadSchedules()
    }, [])

    const loadSchedules = async () => {
        try {
            const response = await restApi.get("/schedule/get-all-schedules")
            setMatches(response.data)
        }
        catch (err) {
            if (err.response) {
                // Not in the 200 reponse range
                console.log(err.response.data)
                console.log(err.response.status)
                console.log(err.response.headers)
            }
            else {
                console.log(`Error: ${err.message}`)
            }

        }
    }

    const onDelete = async (id) => {
        await restApi.delete(`/schedule/delete-schedule/${id}`)
        loadSchedules()
    }

    return (
        <div>
            <h3 className='current-header'>Current Schedule</h3>
            <div className='add-btn-holder'>
                <Link to="schedule" className='add-schedule-btn'>Add Schedule</Link>
            </div>
            {matches.length > 0 ? (
                matches.map((match) => (
                    <Match key={match.id} match={match} onDelete={onDelete}/>
                ))  
            ) : (
                'No match scheduled'
            )
            }
        </div>
    )
}

export default MatchesDisplay