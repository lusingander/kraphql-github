Examples
====

## Basic

```kotlin
val q = query {
    repository(name = "kraphql-github", owner = "lusingander") {
        name
        description
        owner {
            login
            avatarUrl
        }
        issue(number = 1) {
            title
            author {
                login
            }
        }
    }
}
println(q.toString())
```

- specifies the route type value (`query`) and calls the required fields
- `query` can be converted to String by calling `toString`
- specify arguments as would in Kotlin if want to set arguments

## Enum / Input types

```kotlin
    val q = query {
        search(query = "kotlin in:name", type = SearchType.REPOSITORY) {
            nodes {
                `on Repository` {
                    pullRequests(orderBy = IssueOrder(direction = OrderDirection.DESC, field = IssueOrderField.CREATED_AT)) {
                        nodes {
                            number
                            title
                            updatedAt
                        }
                    }
                }
            }
        }
    }
```

- `enum` is defined as Kotlin enum
- `input type` is defined as Kotlin class
- just set the value and pass as arguments as with scalars

## Union / Interface

```kotlin
val q = query {
    repository(name = "kraphql-github", owner = "lusingander") {
        pullRequest(number = 1) {
            timelineItems {
                nodes {
                    `on AssignedEvent` {
                        actor {
                            `on User` {
                                login
                                company
                                email
                            }
                            `on Organization` {
                                login
                                teamsUrl
                                organizationBillingEmail
                            }
                            `on Bot` {
                                resourcePath
                            }
                        }
                    }
                    `on IssueComment` { 
                        author { 
                            login
                        }
                    }
                }
            }
        }
    }
}
```

- `union` and `interface` can be called by `on XXX` expression
