# GitHub Viewer

A modern Android application for browsing GitHub content with authentication support and rich
repository exploration features.

## 3rd Party Dependencies

| Library     | Version |
|:------------|:--------|
| Retrofit    | v2.11.0 |
| Dagger Hilt | v2.51.1 |
| Coil        | v3.1.0  |
## UML Design
![Home Page](./uml.png)

## ScreenShots

| Feature          | ScreenShot                                               |
|------------------|----------------------------------------------------------|
| Home Page        | ![Home Page](./screenshots/home.png)                     |
| Language Filter  | ![Language Filter](./screenshots/filter_by_language.png) |
| Sort Type Filter | ![Sort Filter](./screenshots/filter_by_sort_type.png)    |
| Logon Page       | ![Logon Page ](./screenshots/logon.png)                  |
| User Page        | ![User Page](./screenshots/user_info.png)                |
| Logoff Page      | ![Logoff Page](./screenshots/logoff.png)                 |
| Error Page       | ![Error Page](./screenshots/network_error.png)           |

## Features

### Anonymous Browsing

- Browse trending repositories without logging in
- View popular open-source projects across different categories
- Discover trending developers and topics

### Repository Exploration

- View repository details including:
    - Description
    - Star count
    - Fork count
    - Primary language
    - Recent activity
- Browse README files in-app
- View issues and pull requests

### Advanced Search

- Search repositories by name or description
- Filter by programming language
- Sort results by:
    - Stars (most/least)
    - Recently updated
    - Number of forks

### Secure Authentication

- GitHub OAuth login
- Persistent session (survives app restarts)
- Secure token storage
- One-tap logout functionality

### Issue Management

- Create new issues in your repositories
- View and comment on existing issues
- Issue templates support

### Robust UX

- Responsive design for both portrait and landscape
- Comprehensive error handling:
    - Network connectivity issues
    - API rate limits
    - Invalid user input
- Loading states and empty views
- Dark/light theme support

## Technical Stack

- **Kotlin** - Primary development language
- **MVVM Architecture** - Clean separation of concerns
- **Jetpack Components**:
    - ViewModel
    - LiveData
    - Room (for local caching)
    - Navigation Component
- **Coroutines & Flow** - Asynchronous operations
- **Retrofit** - Network requests
- **Coil** - Image loading
- **Dagger Hilt** - Dependency injection
- **Material Components** - Modern UI elements

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/AshurQiang/GithubViewer.git