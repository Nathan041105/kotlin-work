// COMP2850 Portfolio: Week 3
// Tests for median()

import io.kotest.core.spec.style.FreeSpec
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe

@Suppress("Unused")
class MedianTest : FreeSpec({

    // Original test: Empty list
    "Exception when size=0" {
        shouldThrow<IllegalArgumentException> {
            median(emptyList<Float>())
        }
    }

    // Test 1: One element
    "Median of a single-element list" {
        median(listOf(42.0f)) shouldBe 42.0f
    }

    // Test 2: Two elements
    "Median of two unsorted elements" {
        median(listOf(10.0f, 2.0f)) shouldBe 6.0f
    }

    // Test 3: Three elements
    "Median of three unsorted elements" {
        median(listOf(9.0f, 1.0f, 5.0f)) shouldBe 5.0f
    }

    // Test 4: Four elements
    "Median of four unsorted elements" {
        median(listOf(20.0f, 2.0f, 8.0f, 4.0f)) shouldBe 6.0f
    }
})