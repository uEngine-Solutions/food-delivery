<template>
    <div>
        <String label="메뉴 ID" v-model="value.menuId" :editMode="editMode"/>
        <String label="메뉴 이름" v-model="value.menuName" :editMode="editMode"/>
        <String label="재고 상태" v-model="value.stockStatus" :editMode="editMode"/>
        <String label="품절 여부" v-model="value.availability" :editMode="editMode"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity.vue'
import String from './primitives/String.vue'
import Money from './vo/Money.vue'

export default {
    name: 'Menu',
    mixins:[BaseEntity],
    components:{
        String,
        Money,
    },
    
    data: () => ({
        path: "menus"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
