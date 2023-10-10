package com.github.lusingander.kraphql.github

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DslTest {

    @Test
    fun query() {
        val q = query {
            search(query = "kotlin in:name sort:stars", first = 10, type = SearchType.REPOSITORY) {
                nodes {
                    `on Repository` {
                        name
                        owner {
                            login
                        }
                        description
                        stargazerCount
                        pullRequests(first = 5, orderBy = IssueOrder(field = IssueOrderField.UPDATED_AT, direction = OrderDirection.DESC)) {
                            nodes {
                                number
                                title
                                updatedAt
                            }
                        }
                    }
                }
                repositoryCount
            }
        }

        val actual = q.toString()

        val expected = """
            query { search(first: 10, query: "kotlin in:name sort:stars", type: REPOSITORY) { nodes { ...on Repository { name owner { login } description stargazerCount pullRequests(first: 5, orderBy: { direction: DESC, field: UPDATED_AT }) { nodes { number title updatedAt } } } } repositoryCount } }
        """.trimIndent()

        assertEquals(expected, actual)
    }
}