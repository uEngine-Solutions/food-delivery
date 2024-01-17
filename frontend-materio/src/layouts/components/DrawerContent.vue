<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '사용자 주문 관리' }" />
        <VerticalNavLink
            :item="{
                title: '주문',
                to: '/orders',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '라이더 관리' }" />
        <VerticalNavLink
            :item="{
                title: '라이더',
                to: '/riders',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '가게 관리' }" />
    </ul>
</template>
