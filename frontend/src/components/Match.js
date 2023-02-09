import React from 'react'
import { Link } from 'react-router-dom'
import './Match.css'

const Match = ({ match, onDelete }) => {

    return (
        <div className='match'>
            <h3 className='match-text'>{match.home} vs {match.away}</h3> 
            <h4 className='match-text'>{match.date}</h4>
            <Link
                className='match-btn update-btn'
                to={`update-schedule/${match.id}`}
            >
                Update
            </Link>
            <button 
                className='match-btn remove-btn'
                onClick={()=>{onDelete(match.id)}}
            >
                Remove
            </button>                    
        </div>
    )
}

export default Match