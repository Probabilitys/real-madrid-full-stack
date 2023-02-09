import React, { useState, useEffect } from 'react'
import SearchBar from '../components/SearchBar'
import PlayerComponent from '../components/PlayerComponent'
import restApi from '../api/restApi'

// A page displaying the Players

const Players = () => {

    const TITLE = {        
        number: "No.",
        position: "Pos.",
        name: "Player",
        birthDate: "Birth Date"
    }

    const [players, setPlayers] = useState([])

    const [searchValue, setSearchValue] = useState('')

    useEffect(() => {
        const fetchPlayers = async () => {
            try {
                const response = await restApi.get("/player/get-all-players")
                setPlayers(response.data)
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
        fetchPlayers()
    }, [])

    function handleSearch(e) {
        setSearchValue(e.target.value)
    }

    const filterPlayers = players.filter((player) => {
        return searchValue.length === 0 || player.name.includes(searchValue)
    })

    return (
        <>
            <h1 className='page-title'>Our Team</h1>
            <SearchBar onSearch={handleSearch} />
            <PlayerComponent player={TITLE} />
            {
                filterPlayers.map((player) => {
                    return <PlayerComponent key={player.number} player={player} />
                })
            }   
        </>
    )
}

export default Players
