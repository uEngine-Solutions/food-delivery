<template>
    <div>
        <String label="라이더 ID" v-model="value.riderId" :editMode="editMode"/>
        <String label="이름" v-model="value.riderName" :editMode="editMode"/>
        <String label="라이더 상태" v-model="value.riderStatus" :editMode="editMode"/>

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

export default {
    name: 'Rider',
    mixins:[BaseEntity],
    components:{
        String,
    },
    
    data: () => ({
        path: "riders"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
