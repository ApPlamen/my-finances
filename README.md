# My finances

## How to run

### Setup

<details>
<summary>Setup the databases (using Podman)</summary>

Pull latest Postgres image:
```
podman pull postgres:latest
```

Create all the databases
- Users database:
```
podman run -e POSTGRES_DB=my_finances_users_db -e POSTGRES_PASSWORD=postgres --name my_finances_users_db \
  --mount type=volume,src=my_finances_users_db,dst=/var/lib/postgresql/data -p 5434:5432 -d postgres:latest
```
</details>

### Start up the application
1. Navigate to the repository folder
2. Start all the databases
- Users database:
```
podman start my_finances_users_db
```
3. Run the services
```
podman compose up
```
