const API_URL = 'http://localhost:8080'

export const getMembers = async () => {
  const response = await fetch(`${API_URL}/chess_player`)
  const members = await response.json()
  return members
}

export const getMemberById = async (memberId) => {
  const response = await fetch(`${API_URL}/chess_player/${memberId}`)
  const member = await response.json()
  return member
}

export const saveMember = async (member) => {
  const response = await fetch(`${API_URL}/chess_player`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(member),
  })
  if (!response.ok) {
    const data = await response.json()
    return data
  }
}

export const patchMember = async (member, id) => {
  const response = await fetch(`${API_URL}/chess_player/${id}`, {
    method: 'PATCH',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(member),
  })
  if (!response.ok) {
    const data = await response.json()
    return data
  }
}

export const deleteMemberById = async (memberId) => {
  await fetch(`${API_URL}/chess_player/${memberId}`, {
    method: 'DELETE',
  })
}
