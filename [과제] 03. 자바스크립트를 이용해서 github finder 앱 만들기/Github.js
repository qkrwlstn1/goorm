class Github {
    constructor() {
        this.client_id = '23cea4b8f3c91ff07211';
        this.client_secret = 'bb24d91e89dc9aed3394a12f920bbbbe968ba6dd';
        this.repos_count = 5;
        this.repos_sort = 'created:asc';
        this.token = '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';
    }//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

    async getUser(user) {
        const profileResponse = await fetch(`https://api.github.com/users/${user}`, {
            headers: {
                Authorization: `Bearer ${this.token}`
            }
        });
        const repoResponse = await fetch(`https://api.github.com/users/${user}/repos?per_page=${this.repos_count}&sort=${this.repos_sort}`, {
            headers: {
                Authorization: `Bearer ${this.token}`
            }
        });

        const profile = await profileResponse.json();
        const repos = await repoResponse.json();
        return {
            profile,
            repos
        }
    }
}

